package com.nonononoki.alovoa.model;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nonononoki.alovoa.Tools;
import com.nonononoki.alovoa.component.TextEncryptorConverter;
import com.nonononoki.alovoa.entity.Gender;
import com.nonononoki.alovoa.entity.User;
import com.nonononoki.alovoa.entity.UserBlock;
import com.nonononoki.alovoa.entity.UserImage;
import com.nonononoki.alovoa.entity.UserIntention;
import com.nonononoki.alovoa.entity.UserReport;

import lombok.Data;

@Data
@Component
public class UserDto {

	@JsonIgnore
	private long id;

	private String idEncoded;

	private String firstName;
	private int age;
	private float donationAmount;
	private Gender gender;
	private Set<Gender> preferedGenders;
	private UserIntention intention;

	private String profilePicture;
	private List<UserImage> images;

	private String description;

	private int distanceToUser;
	private double totalDonations;

	private Date activeDate;

	private List<UserBlock> blockedByUsers;
	private List<UserReport> reportedByUsers;

	private List<UserBlock> blockedUsers;
	
	private boolean blockedByCurrentUser;
	private boolean reportedByCurrentUser;
	private boolean likedByCurrentUser;
	private boolean hiddenByCurrentUser;

	public static UserDto userToUserDto(User user, User currentUser, TextEncryptorConverter textEncryptor)
			throws Exception {
		UserDto dto = new UserDto();
		dto.setId(user.getId());
		String en = textEncryptor.encode(Long.toString(user.getId()));
		dto.setIdEncoded(en);
		dto.setActiveDate(user.getActiveDate());
		dto.setAge(user.getAge());
		dto.setDescription(user.getDescription());
		dto.setFirstName(user.getFirstName());
		dto.setGender(user.getGender());
		dto.setPreferedGenders(user.getPreferedGenders());
		dto.setImages(user.getImages());
		dto.setGender(user.getGender());
		dto.setIntention(user.getIntention());
		dto.setProfilePicture(user.getProfilePicture());
		dto.setBlockedUsers(user.getBlockedUsers());
		double donations = 0;
		for (int i = 0; user.getDonations() != null && i < user.getDonations().size(); i++) {
			donations += user.getDonations().get(i).getAmount();
		}
		dto.setTotalDonations(donations);
		dto.setBlockedByUsers(user.getBlockedByUsers());
		dto.setReportedByUsers(user.getReportedByUsers());
		
		dto.blockedByCurrentUser = currentUser.getBlockedUsers().stream().anyMatch(o -> o.getUserTo().getId().equals(user.getId()));
		dto.reportedByCurrentUser = currentUser.getReported().stream().anyMatch(o -> o.getUserTo().getId().equals(user.getId()));
		dto.likedByCurrentUser = currentUser.getLikes().stream().anyMatch(o -> o.getUserTo().getId().equals(user.getId()));
		dto.hiddenByCurrentUser = currentUser.getHiddenUsers().stream().anyMatch(o -> o.getUserTo().getId().equals(user.getId()));
		double dist = Tools.getDistanceToUser(user, currentUser);
		dto.setDistanceToUser((int) Math.round(dist));
		return dto;
	}
}
