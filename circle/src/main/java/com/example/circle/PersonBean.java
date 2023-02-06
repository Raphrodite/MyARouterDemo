package com.example.circle;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * * Copyright * 圣通电力
 *
 * @ProjectName: MyARouter
 * @Package: com.example.circle
 * @ClassName: PersonBean
 * @Description:
 * @Author: Raphrodite
 * @CreateDate: 2023/1/29
 */
public class PersonBean implements Parcelable {

    private String name;
    private String age;

    public PersonBean(String name, String age) {
        this.name = name;
        this.age = age;
    }

    protected PersonBean(Parcel in) {
        name = in.readString();
        age = in.readString();
    }

    public static final Creator<PersonBean> CREATOR = new Creator<PersonBean>() {
        @Override
        public PersonBean createFromParcel(Parcel in) {
            return new PersonBean(in);
        }

        @Override
        public PersonBean[] newArray(int size) {
            return new PersonBean[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "PersonBean{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(age);
    }
}
