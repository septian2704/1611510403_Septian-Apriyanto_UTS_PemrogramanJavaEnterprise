package com.exa.api.entity

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.GeneratedValue
import javax.persistence.Table
import javax.persistence.GenerationType
import javax.validation.constraints.NotNull
import javax.persistence.Column

@Entity
@Table(name = "categories")
class Category{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id

    @NotNull
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String nama_buku

    @NotNull
    @Column(nullable = false)
    String nama_peminjam

    @NotNull
    @Column(nullable = false)
    Integer nim
}