package edu.ben.classconnect.entities;

import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "wall")
@AttributeOverride(name = "id", column = @Column(name = "idWall", nullable = false, columnDefinition = "BIGINT"))
public class Wall extends BaseEntity {

	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST, CascadeType.DETACH })
	@JoinColumn(name = "owner")
	private User owner;

	@Column(name = "wall_name")
	private String wallName;

	@Column(name = "allow_comments")
	private int allowComments;

	@Column(name = "show_members")
	private int showMembers;

	@Column(name = "show_recent_posts")
	private int showRecentPosts;

	@Column(name = "wall_color")
	private String wallColor;
	
	@Column(name = "wall_description")
	private String wallDescription;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "wall")
	private Set<WallAccess> members;

	
	
	public String getWallDescription() {
		return wallDescription;
	}

	public void setWallDescription(String wallDescription) {
		this.wallDescription = wallDescription;
	}

	public Set<WallAccess> getMembers() {
		return members;
	}

	public void setMembers(Set<WallAccess> members) {
		this.members = members;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public String getWallName() {
		return wallName;
	}

	public void setWallName(String wallName) {
		this.wallName = wallName;
	}

	public int getAllowComments() {
		return allowComments;
	}

	public void setAllowComments(int allowComments) {
		this.allowComments = allowComments;
	}

	public int getShowMembers() {
		return showMembers;
	}

	public void setShowMembers(int showMembers) {
		this.showMembers = showMembers;
	}

	public int getShowRecentPosts() {
		return showRecentPosts;
	}

	public void setShowRecentPosts(int showRecentPosts) {
		this.showRecentPosts = showRecentPosts;
	}

	public String getWallColor() {
		return wallColor;
	}

	public void setWallColor(String wallColor) {
		this.wallColor = wallColor;
	}

}
