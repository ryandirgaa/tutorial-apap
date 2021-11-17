package apap.tutorial.emsidi.model;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class PasswordModel {
    private String oldPassword;
    private String newPassword;
    private String confirmedPassword;
}