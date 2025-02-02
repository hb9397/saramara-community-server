package com.kakao.saramaracommunity.member.dto.response;

import java.util.Set;

import com.kakao.saramaracommunity.member.entity.Role;
import com.kakao.saramaracommunity.member.entity.Type;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MemberInfoResDto {
	private String email;
	private String nickname;
	private Type type;
	private Set<Role> role;
	private MemberImageDto memberImage;

	@Builder
	public MemberInfoResDto(String email, String nickname, Type type, Set<Role> role, MemberImageDto memberImageDto){
		this.email = email;
		this.nickname = nickname;
		this.type = type;
		this.role = role;
		this.memberImage = memberImageDto;
	}
}
