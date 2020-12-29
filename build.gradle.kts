import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.4.1"
	id("io.spring.dependency-management") version "1.0.10.RELEASE"
	kotlin("jvm") version "1.4.21"
	kotlin("plugin.spring") version "1.4.21"
	id ("org.jetbrains.kotlin.plugin.jpa") version "1.3.30" //jpa에서 사용하는 클래스들의 상속가능과 기본생성자를 자동으로 해주는 플러그인
}


group = "com.application"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

allOpen{
	annotation("javax.persistence.Entity")
}

repositories {
	mavenCentral()
}//https://choiseonjae.github.io/java/maven/repository/%EA%B0%9C%EC%9A%94/    mavencentral?관련 링크

dependencies {
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	testImplementation("org.springframework.boot:spring-boot-starter-test")

	implementation("org.springframework.boot:spring-boot-starter-web")//웹관련의존성
	//데이터 베이스를 사용하기 위해 JPA 사용 -> 쿼리문으로 처리하지 않고 코틀린 문법으로 처리하는 ORM 사용하기 위해 내장되어있는 Hibernate 사용을 위함
	//이 부분이 상당히 어려움
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")

	implementation("org.jetbrains.kotlin:kotlin-reflect")//리플렉션기능

	runtimeOnly("mysql:mysql-connector-java")
	implementation("org.seleniumhq.selenium:selenium-chrome-driver")
	implementation("org.seleniumhq.selenium:selenium-server:3.9.1")
	implementation("org.mariadb.jdbc:mariadb-java-client") // 마리아 db연결 드라이버 그냥 내장으로 넣어버림
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "1.8"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
//이거 패키지는 대문자가 아니라 소문자로 하는거라 배우기도 햇고 하다보니 에러아니고 고칠수도 있는 것들에 그내용도 있길래 고쳐놓음 확인하고 지우긔

