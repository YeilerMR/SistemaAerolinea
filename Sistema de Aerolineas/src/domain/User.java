package domain;

public class User {

    private String user;
    private String password;
    private String type;
    private String state;

    public User(String user, String password, String type, String state) {
        this.user = user;
        this.password = password;
        this.type = type;
        this.state = state;
    }

    public User() {

    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public String getType() {
        return type;
    }

    public String getState() {
        return state;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String[] getDataName() {
        String[] dataName= {"user","password","type","state"};
        return dataName;
    }

    public String[] getData() {
        String[] data= {user,password,type,state};
        return data;
    }

    @Override
    public String toString() {
        return "User [user=" + user + ", password=" + password + ", type=" + type + ", state=" + state + "]";
    }

}
