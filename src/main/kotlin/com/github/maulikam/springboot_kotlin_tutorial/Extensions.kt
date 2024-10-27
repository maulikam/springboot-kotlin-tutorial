package com.github.maulikam.springboot_kotlin_tutorial

import java.util.*

fun String.toSlug() = lowercase(Locale.getDefault())
    .replace("\n", "")
    .replace("[^a-z\\d\\s]".toRegex(), "")
    .split(" ")
    .joinToString("-")
    .replace("-+".toRegex(), "-")