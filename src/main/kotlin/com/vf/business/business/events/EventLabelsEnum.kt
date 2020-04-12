package com.vf.business.business.events

enum class EventLabelsEnum(val label: String) {
    DIRECT_MESSAGE("direct-message"),
    CLASS_STARTED("class-started"),
    CLASS_ENDED("class-ended"),
    MUTE_ALL("mute-all"),
    MUTE_SINGLE("mute-single"),
    UNMUTE_ALL("unmute-all"),
    UNMUTE_SINGLE("unmute-single")
}