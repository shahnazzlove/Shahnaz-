import java.util.List;


class EmployeeProfile {
    private String name;
    private String surname;
    private String birthDate;

    private String email;
    private String phone;

    private String role;
    private String department;

    private List<String> permissions;
    private List<String> certifications;

    private String employmentDate;


    private EmployeeProfile(Builder builder) {
        this.name = builder.name;
        this.surname = builder.surname;
        this.birthDate = builder.birthDate;
        this.email = builder.email;
        this.phone = builder.phone;
        this.role = builder.role;
        this.department = builder.department;
        this.permissions = builder.permissions;
        this.certifications = builder.certifications;
        this.employmentDate = builder.employmentDate;
    }


    public static class Builder {
        private String name;
        private String surname;
        private String birthDate;

        private String email;
        private String phone;

        private String role;
        private String department;

        private List<String> permissions;
        private List<String> certifications;

        private String employmentDate;

        public Builder setPersonalInfo(String name, String surname, String birthDate) {
            this.name = name;
            this.surname = surname;
            this.birthDate = birthDate;
            return this;
        }

        public Builder setContactInfo(String email, String phone) {
            this.email = email;
            this.phone = phone;
            return this;
        }

        public Builder setRole(String role) {
            this.role = role;
            return this;
        }

        public Builder setDepartment(String department) {
            this.department = department;
            return this;
        }

        public Builder grantPermissions(List<String> permissions) {
            this.permissions = permissions;
            return this;
        }

        public Builder addCertifications(List<String> certifications) {
            this.certifications = certifications;
            return this;
        }

        public Builder setEmploymentDate(String date) {
            this.employmentDate = date;
            return this;
        }


        public EmployeeProfile build() {
            return new EmployeeProfile(this);
        }


        public static Builder developerTemplate() {
            return new Builder()
                    .setRole("Developer")
                    .setDepartment("IT")
                    .grantPermissions(List.of("Repo Access", "Docs Access"));
        }


        public static Builder managerTemplate() {
            return new Builder()
                    .setRole("Manager")
                    .setDepartment("Management")
                    .grantPermissions(List.of("Reports Access", "Team Control"));
        }


        public static Builder adminTemplate() {
            return new Builder()
                    .setRole("Admin")
                    .setDepartment("System")
                    .grantPermissions(List.of("Full Access", "DB Access", "Security Control"));
        }
    }

    @Override
    public String toString() {
        return "EmployeeProfile{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", role='" + role + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}


public class Main {
    public static void main(String[] args) {

        EmployeeProfile dev = EmployeeProfile.Builder.developerTemplate()
                .setPersonalInfo("Ivan", "Petrov", "2000-01-01")
                .setContactInfo("ivan@mail.com", "+77770001122")
                .setEmploymentDate("2024-01-10")
                .build();

        System.out.println(dev);

        EmployeeProfile admin = EmployeeProfile.Builder.adminTemplate()
                .setPersonalInfo("Anna", "Kim", "1998-05-12")
                .setContactInfo("anna@mail.com", "+77770003344")
                .setEmploymentDate("2023-09-01")
                .build();

        System.out.println(admin);
    }
}