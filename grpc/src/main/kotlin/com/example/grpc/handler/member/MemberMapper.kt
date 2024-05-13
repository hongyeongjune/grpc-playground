package com.example.grpc.handler.member

import com.example.grpc.service.member.dto.MemberDto
import com.example.grpc.utils.toTimestamp
import com.example.proto.member.MemberResponse
import com.example.proto.member.memberResponse
import com.google.protobuf.Int32Value

object MemberMapper {
    fun fromMemberResponse(memberDto: MemberDto): MemberResponse {
        return memberResponse {
            id = memberDto.id
            name = memberDto.name
            createdBy = memberDto.createdBy
            memberDto.modifiedBy?.let { modifiedBy = Int32Value.of(it) }
            createdDate = memberDto.createdDate.toTimestamp()
            modifiedDate = memberDto.modifiedDate.toTimestamp()
        }
    }
}