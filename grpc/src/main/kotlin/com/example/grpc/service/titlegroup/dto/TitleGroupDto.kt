package com.example.grpc.service.titlegroup.dto

import com.example.grpc.entity.titlegroup.TitleGroupEntity
import java.time.LocalDateTime

data class TitleGroupDto(
    val id: Int,
    val subject: String,
    val createdBy: Int,
    val modifiedBy: Int? = null,
    val createdDate: LocalDateTime,
    val modifiedDate: LocalDateTime,
) {
    companion object {
        fun of(titleGroupEntity: TitleGroupEntity): TitleGroupDto {
            return with(titleGroupEntity) {
                TitleGroupDto(
                    id = id!!,
                    subject = subject,
                    createdBy = createdBy,
                    modifiedBy = modifiedBy,
                    createdDate = createdDate,
                    modifiedDate = modifiedDate,
                )
            }
        }
    }
}