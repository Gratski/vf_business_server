package com.vf.business.business.dao.models.discipline

/**
 * This enum matches the Days of Week according to Java Calendar
 */
enum class WeekDayEnum(private val positionalId: Int) {
    SUNDAY(1),
    MONDAY(2),
    TUESDAY(3),
    WEDNESDAY(4),
    THURSDAY(5),
    FRIDAY(6),
    SATURDAY(7);

    fun value(): Int =
        this.positionalId
}