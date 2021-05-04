package prob4;

public class Person {
	static int numberOfPerson=0;
	int age;
	String name;

	Person() {
		age = 12;
		name = "김자바";
		numberOfPerson++;
	}

	Person(int age, String name) {
		this.age = age;
		this.name = name;
		numberOfPerson++;
	}

	void selfIntroduce() {
		System.out.println("내 이름은 " + this.name + "이며, 나이는 " + age + "입니다.");
	}

	int getPopulation() {
		return numberOfPerson;
	}
}
