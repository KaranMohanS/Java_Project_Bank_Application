package com.user;

import java.util.ArrayList;
import java.util.List;

import com.App;

public class User {

    public static List<User> list = new ArrayList<>();

    public static void adduser(User user) {
        int id = list.size() + 1;
        user.setId(id);
        list.add(user);
    }

    public static void printuser() {
        for (User x : list) {
            System.out.println(x);
        }
    }

    public static void getuser(int id) {
        for (User x : list) {
            if (x.getId() == id) {
                System.out.println(x);
            }
        }

    }

    public static void update(int id, String field) {
        for (User x : list) {
            if (x.getId() == id) {
                switch (field) {
                    case "name":
                        System.out.println("enter new name");
                        String name = App.scanner.nextLine();
                        x.setName(name);
                        break;
                    case "age":
                        System.out.println("enter new age");
                        int value = App.scanner.nextInt();
                        App.scanner.nextLine();
                        x.setAge((int) value);
                        break;
                    case "gender":
                        System.out.println("enter new gender");
                        String gender = App.scanner.nextLine();
                        x.setGender(gender);
                        break;

                    case "ph":

                        System.out.println("enter new ph");
                        long ph = App.scanner.nextLong();
                        App.scanner.nextLine();
                        x.setPh(ph);
                        break;

                    case "address":

                    System.out.println("enter new address");
                    String add=App.scanner.nextLine();
                    x.setAddress(add);
                    break;

                    default:
                        break;
                }
            }
        }
    }

    public static void delete(int id)
    {
        for(User x:list)
        {
            if(x.getId()==id)
            {
                list.remove(id);
            }
        }
    }

    int id;
    String name;
    int age;
    String gender;
    long ph;
    String address;

    public User(int id, String name, int age, String gender, long ph, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.ph = ph;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public long getPh() {
        return ph;
    }

    public void setPh(long ph) {
        this.ph = ph;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", ph=" + ph + ", address="
                + address + "]";
    }

}
