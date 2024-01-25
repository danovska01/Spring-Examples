package project.model.binding;

public class UserRegisterBindingModel {

    private String password;
    private String confirmPassword;





    public UserRegisterBindingModel() {
    }







    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }



    public String getConfirmPassword() {
        return confirmPassword;
    }
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
