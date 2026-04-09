package selfgemma.talk.ui.llmchat

import selfgemma.talk.data.Accelerator
import selfgemma.talk.data.Model
import java.io.File
import kotlin.io.path.createTempDirectory
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class LlmChatModelHelperTest {
  @Test
  fun resolveImportedCpuWeightCacheFile_returnsSidecarForImportedCpuModel() {
    val tempDir = createTempDirectory("llm-cache-test").toFile()
    val modelFile = File(tempDir, "gemma.litertlm").apply { writeText("model") }
    val cacheFile = File("${modelFile.absolutePath}.xnnpack_cache").apply { writeText("cache") }

    try {
      val result =
        resolveImportedCpuWeightCacheFile(
          model = Model(name = "gemma.litertlm", imported = true),
          accelerator = Accelerator.CPU.label,
          modelPath = modelFile.absolutePath,
        )

      assertEquals(cacheFile.absolutePath, result?.absolutePath)
    } finally {
      tempDir.deleteRecursively()
    }
  }

  @Test
  fun resolveImportedCpuWeightCacheFile_ignoresNonImportedOrNonCpuModels() {
    val tempDir = createTempDirectory("llm-cache-test").toFile()
    val modelFile = File(tempDir, "gemma.litertlm").apply { writeText("model") }
    File("${modelFile.absolutePath}.xnnpack_cache").apply { writeText("cache") }

    try {
      assertNull(
        resolveImportedCpuWeightCacheFile(
          model = Model(name = "gemma.litertlm", imported = false),
          accelerator = Accelerator.CPU.label,
          modelPath = modelFile.absolutePath,
        )
      )
      assertNull(
        resolveImportedCpuWeightCacheFile(
          model = Model(name = "gemma.litertlm", imported = true),
          accelerator = Accelerator.GPU.label,
          modelPath = modelFile.absolutePath,
        )
      )
    } finally {
      tempDir.deleteRecursively()
    }
  }
}
