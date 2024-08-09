package JavaFakerLibrary;

import com.github.javafaker.Faker;

public class dataGenerations {
    public static void main(String[] args) {
        Faker faker = new Faker();
        for (int i = 0; i < 10; i++) {
            String fname = faker.name().firstName();
            String lname = faker.name().lastName();
            String phoneNumber = faker.phoneNumber().phoneNumber();
            String fadd = faker.address().fullAddress();
        System.out.println("fname: " + fname + "lname: "+ lname +"phone :"+phoneNumber+"fadd"+fadd);

        }
    }
}
