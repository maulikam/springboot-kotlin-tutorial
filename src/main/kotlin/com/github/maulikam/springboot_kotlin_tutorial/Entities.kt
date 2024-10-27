package com.github.maulikam.springboot_kotlin_tutorial

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.LocalDateTime

@Entity
class Article(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var title: String?,
    var content: String,
    var createdAt: LocalDateTime = LocalDateTime.now(),
    var slug: String? = title?.toSlug()) // check for null safe before converting into slug