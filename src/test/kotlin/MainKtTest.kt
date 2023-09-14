import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun countComissionMaestroWithinLimitsMore75() {
        // Лимиты для Mastercard и Maestro
        val limitMastMaesDaily = 150_000
        val limitMastMaesMonthly = 600_000

        val result = countComission("Maestro", 70100, 5000)
        assertEquals("50.0", result)
    }

    @Test
    fun countComissionMaestroWithinLimitsLess75() {
        // Лимиты для Mastercard и Maestro
        val limitMastMaesDaily = 150_000
        val limitMastMaesMonthly = 600_000

        val result = countComission("Maestro", 1000, 5000)
        assertEquals("0.0", result)
    }

    @Test
    fun countComissionMaestroOutOfFirstLimits() {
        // Лимиты для Mastercard и Maestro
        val limitMastMaesDaily = 150_000
        val limitMastMaesMonthly = 600_000

        val result = countComission("Maestro", 70000, 160000)
        assertEquals("превышен лимит", result)
    }

    @Test
    fun countComissionMaestroOutOfSecondLimits() {
        // Лимиты для Mastercard и Maestro
        val limitMastMaesDaily = 150_000
        val limitMastMaesMonthly = 600_000

        val result = countComission("Maestro", 650000, 100000)
        assertEquals("превышен лимит", result)
    }

    @Test
    fun countComissionMastercardWithinLimitsMore75() {
        // Лимиты для Mastercard и Maestro
        val limitMastMaesDaily = 150_000
        val limitMastMaesMonthly = 600_000

        val result = countComission("Mastercard", 70100, 5000)
        assertEquals("50.0", result)
    }

    @Test
    fun countComissionMastercardWithinLimitsLess75() {
        // Лимиты для Mastercard и Maestro
        val limitMastMaesDaily = 150_000
        val limitMastMaesMonthly = 600_000

        val result = countComission("Mastercard", 1000, 5000)
        assertEquals("0.0", result)
    }

    @Test
    fun countComissionMastercardOutOfFirstLimits() {
        // Лимиты для Mastercard и Maestro
        val limitMastMaesDaily = 150_000
        val limitMastMaesMonthly = 600_000

        val result = countComission("Mastercard", 70000, 160000)
        assertEquals("превышен лимит", result)
    }

    @Test
    fun countComissionMastercardOutOfSecondLimits() {
        // Лимиты для Mastercard и Maestro
        val limitMastMaesDaily = 150_000
        val limitMastMaesMonthly = 600_000

        val result = countComission("Mastercard", 650000, 100000)
        assertEquals("превышен лимит", result)
    }

    @Test
    fun countComissionVisaWithinLimits() {
        // Лимиты для Visa и Мир
        val limitVisaMirDaily = 150_000
        val limitVisaMirMonthly = 600_000

        val result = countComission("Visa", 1000, 5000)
        assertEquals("37.5", result)
    }

    @Test
    fun countComissionVisaWithinLimits35() {
        // Лимиты для Visa и Мир
        val limitVisaMirDaily = 150_000
        val limitVisaMirMonthly = 600_000

        val result = countComission("Visa", 1000, 1000)
        assertEquals("35.0", result)
    }

    @Test
    fun countComissionVisaOutOfFirstLimits() {
        // Лимиты для Mastercard и Maestro
        val limitMastMaesDaily = 150_000
        val limitMastMaesMonthly = 600_000

        val result = countComission("Visa", 100000, 160000)
        assertEquals("превышен лимит", result)
    }

    @Test
    fun countComissionVisaOutOfSecondLimits() {
        // Лимиты для Mastercard и Maestro
        val limitMastMaesDaily = 150_000
        val limitMastMaesMonthly = 600_000

        val result = countComission("Visa", 650000, 100000)
        assertEquals("превышен лимит", result)
    }

    @Test
    fun countComissionMirWithinLimits() {
        // Лимиты для Visa и Мир
        val limitVisaMirDaily = 150_000
        val limitVisaMirMonthly = 600_000

        val result = countComission("Visa", 2000, 4000)
        assertEquals("35.0", result)
    }

    @Test
    fun countComissionMirWithinLimits35() {
        // Лимиты для Visa и Мир
        val limitVisaMirDaily = 150_000
        val limitVisaMirMonthly = 600_000

        val result = countComission("Visa", 2000, 100)
        assertEquals("35.0", result)
    }

    @Test
    fun countComissionVisaWithinLimitsWithoutSumOfDeals() {
        // Лимиты для Visa и Мир
        val limitVisaMirDaily = 150_000
        val limitVisaMirMonthly = 600_000

        val result = countComission("Visa", sum = 5000)
        assertEquals("37.5", result)
    }

    @Test
    fun countComissionVKWithSumOfDeals() {
        // Лимиты для VKpay
        val limitVKOneTransaction = 15_000
        val limitVKMonthly = 40_000

        val result = countComission(sumOfDeals = 10000, sum = 10000)
        assertEquals("0.0", result)
    }

    @Test
    fun countComissionVK() {
        // Лимиты для VKpay
        val limitVKOneTransaction = 15_000
        val limitVKMonthly = 40_000

        val result = countComission(sum = 10000)
        assertEquals("0.0", result)
    }

    @Test
    fun countComissionVKOutOfFirstLimit() {
        // Лимиты для VKpay
        val limitVKOneTransaction = 15_000
        val limitVKMonthly = 40_000

        val result = countComission(sumOfDeals = 70000, sum = 10000)
        assertEquals("превышен лимит", result)
    }

    @Test
    fun countComissionVKOutOSecondLimit() {
        // Лимиты для VKpay
        val limitVKOneTransaction = 15_000
        val limitVKMonthly = 40_000

        val result = countComission(sumOfDeals = 10000, sum = 20000)
        assertEquals("превышен лимит", result)
    }
}