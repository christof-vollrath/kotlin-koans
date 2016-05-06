package iii_conventions

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int)

operator fun MyDate.rangeTo(other: MyDate): DateRange = DateRange(this, other)

infix operator fun MyDate.plus(interval: TimeInterval): MyDate = this.addTimeIntervals(interval, 1)
infix operator fun MyDate.plus(repeated: RepeatedTimeInterval): MyDate = this.addTimeIntervals(repeated.interval, repeated.number)


enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

data class RepeatedTimeInterval(val interval: TimeInterval, val number: Int)

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

