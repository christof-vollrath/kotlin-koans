package iii_conventions

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int)

operator fun MyDate.rangeTo(other: MyDate): DateRange = DateRange(this, other)

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

class DateRange(val start: MyDate, val endInclusive: MyDate) {
    operator fun iterator(): Iterator<MyDate> = object: Iterator<MyDate> {
        var currentDate: MyDate = start
        override fun hasNext(): Boolean = currentDate <= endInclusive
        override fun next(): MyDate {
            var result = currentDate
            currentDate = currentDate.nextDay()
            return result
        }
    }

}

