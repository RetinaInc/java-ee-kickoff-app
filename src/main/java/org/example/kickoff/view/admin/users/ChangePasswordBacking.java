package org.example.kickoff.view.admin.users;

import static org.example.kickoff.validator.Demo.canUpdate;
import static org.omnifaces.util.Messages.addGlobalInfo;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.validation.constraints.Size;

import org.example.kickoff.business.UserService;
import org.example.kickoff.model.User;

@ManagedBean
@ViewScoped
public class ChangePasswordBacking {

	@EJB
	private UserService userService;

	private User user;

	@Size(min=8)
	private String newPassword;
	
	public void changePassword() {
		if (canUpdate(user)) {
			userService.updatePassword(user, newPassword);
			addGlobalInfo("Password for user {0} successfully changed.", user.getEmail());
		}
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

}
