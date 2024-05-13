package com.example.grpc.service.member.dto

import com.example.proto.member.CreateMemberRequest

data class CreateMemberDto(
    val name: String,
    val createdBy: Int,
) {
    companion object {
        fun of(createMemberRequest: CreateMemberRequest): CreateMemberDto {
            return with(createMemberRequest) {
                CreateMemberDto(
                    name = name,
                    createdBy = createdBy,
                )
            }
        }
    }
}