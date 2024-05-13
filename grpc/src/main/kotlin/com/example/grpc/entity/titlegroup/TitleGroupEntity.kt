package com.example.grpc.entity.titlegroup

import com.example.grpc.service.titlegroup.dto.CreateTitleGroupDto
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime

@Table("title_group")
class TitleGroupEntity(
    @Id
    val id: Int? = null,
    val subject: String,
    val createdBy: Int,
    val modifiedBy: Int? = null,
    @CreatedDate
    val createdDate: LocalDateTime = LocalDateTime.now(),
    @LastModifiedDate
    val modifiedDate: LocalDateTime = LocalDateTime.now(),
) {
    companion object {
        fun of(createTitleGroupDto: CreateTitleGroupDto): TitleGroupEntity {
            return with(createTitleGroupDto) {
                TitleGroupEntity(
                    subject = subject,
                    createdBy = createdBy,
                )
            }
        }
    }
}