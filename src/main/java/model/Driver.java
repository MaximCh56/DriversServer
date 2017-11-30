package model;


public class Driver {
    private String uuid;
    private String name;
    private String surname;
    private String patronymic;
    private String category;
    private String birthDate;
    private boolean sex;

    public Driver(String name, String surname, String patronymic, String category, String birthDate, boolean sex) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.category = category;
        this.birthDate = birthDate;
        this.sex = sex;
    }

    public Driver() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
