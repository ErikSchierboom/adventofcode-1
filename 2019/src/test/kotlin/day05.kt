import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day05 {

    @Test
    fun runPart01() {
        val memory = Util.getInputAsListOfInt("day05-input.txt", ",").toTypedArray()

        val output = IntCodeComputer(memory)
            .let { program ->
                generateSequence(1) {
                    val signal = program.run(it)
                    if (program.running) signal else null
                }.last()
            }

        assertEquals (4601506, output)
    }

    @Test
    fun runPart02() {
        val memory = Util.getInputAsListOfInt("day05-input.txt", ",").toTypedArray()

        val output = IntCodeComputer(memory)
            .let { program ->
                generateSequence(5) {
                    val signal = program.run(it)
                    if (program.running) signal else null
                }.last()
            }

        assertEquals (5525561, output)
    }
}