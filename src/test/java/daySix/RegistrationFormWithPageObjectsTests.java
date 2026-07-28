package daySix;

import componentsDaySix.RegistrationPage;
import org.junit.jupiter.api.Test;

public class RegistrationFormWithPageObjectsTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillPracticeFormTest() {
        String firstName = "Ruslan";
        String lastName = "Khammatov";
        String fullName = firstName + " " + lastName;
        String userEmail = "khamru@gmail.com";
        String gender = "Male";
        String userNumber = "9873321535";
        String birthYear = "2002";
        String birthMonth = "July";
        String birthDay = "03";
        String birthDate = birthDay + " " + birthMonth + "," + birthYear;
        String subject1 = "English";
        String subject2 = "Physics";
        String subjects = subject1 + ", " + subject2;
        String hobby1 = "Music";
        String hobby2 = "Reading";
        String hobbies = hobby1 + ", " + hobby2;
        String img = "image.png";
        String currentAddress = "Test adress";
        String state = "Uttar Pradesh";
        String city = "Agra";
        String stateAndCity = state + " " + city;
//
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender(gender)
                .setUserNumber(userNumber)
                .setBirthDate(birthDay, birthMonth, birthYear)
                .setSubjects(subject1)
                .setSubjects(subject2)
                .setHobbies(hobby1)
                .setHobbies(hobby2)
                .setPicture(img)
                .setCurrentAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .submit();
//
        registrationPage.verifyResultsModalAppears()
                .verifyResult("Student Name", fullName)
                .verifyResult("Student Email", userEmail)
                .verifyResult("Gender", gender)
                .verifyResult("Mobile", userNumber)
                .verifyResult("Date of Birth", birthDate)
                .verifyResult("Subjects", subjects)
                .verifyResult("Hobbies", hobbies)
                .verifyResult("Picture", img)
                .verifyResult("Address", currentAddress)
                .verifyResult("State and City", stateAndCity);
    }
}
