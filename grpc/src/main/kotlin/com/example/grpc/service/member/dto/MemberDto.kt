package com.example.grpc.service.member.dto

import com.example.grpc.entity.member.MemberEntity
import java.time.LocalDateTime

data class MemberDto(
    val id: Int,
    val name: String,
    val createdBy: Int,
    val modifiedBy: Int?,
    val createdDate: LocalDateTime,
    val modifiedDate: LocalDateTime,
) {
    companion object {
        fun of(memberEntity: MemberEntity): MemberDto {
            return with(memberEntity) {
                MemberDto(
                    id = id!!,
                    name = name,
                    createdBy = createdBy,
                    modifiedBy = modifiedBy,
                    createdDate = createdDate,
                    modifiedDate = modifiedDate,
                )
            }
        }
    }
}