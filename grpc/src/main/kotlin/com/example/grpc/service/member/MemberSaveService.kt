package com.example.grpc.service.member

import com.example.grpc.entity.member.MemberEntity
import com.example.grpc.repository.member.MemberRepository
import com.example.grpc.service.member.dto.CreateMemberDto
import com.example.grpc.service.member.dto.MemberDto
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class MemberSaveService(
    private val memberRepository: MemberRepository,
) {
    @Transactional
    suspend fun createMember(createMemberDto: CreateMemberDto): MemberDto {
        val memberEntity = memberRepository.save(MemberEntity.of(createMemberDto))
        return MemberDto.of(memberEntity)
    }
}