import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day02 {

    @Test
    fun runPart01() {
        val memory = Util.getInputAsListOfInt("day02-input.txt", ",")

        val positionZero = IntCodeComputer(memory.toTypedArray())
            .apply { noun = 12; verb = 2 }
            .also { it.runUntilExit() }
            .positionZero

        assertEquals (5866663, positionZero)
    }

    @Test
    fun runPart02() {
        val memory = Util.getInputAsListOfInt("day02-input.txt", ",")

        val nounVerb = (0..99)
            .crossJoin()
            .first {
                IntCodeComputer(memory.toTypedArray())
                    .apply { noun = it.first; verb = it.second }
                    .also { it.runUntilExit() }
                    .positionZero == 19690720
            }
            .let { it.first * 100 + it.second }

        assertEquals (4259, nounVerb)
    }

    private fun IntRange.crossJoin() = flatMap { it1 -> map { it2 -> it1 to it2} }
}