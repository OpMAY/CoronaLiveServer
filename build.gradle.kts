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
//apply(plugin = "io.spring.dependency-management")
repositories {
	mavenCentral()
	maven {
		url = uri("https://plugins.gradle.org/m2/")
	}
}//https://choiseonjae.github.io/java/maven/repository/%EA%B0%9C%EC%9A%94/    mavencentral?관련 링크

dependencies {
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	testImplementation("org.springframework.boot:spring-boot-starter-test")

	implementation("org.springframework.boot:spring-boot-stater-web")//웹관련의존성
	implementation("org.jetbrains.kotlin:kotlin-reflect")//리플렉션기능

	runtimeOnly("mysql:mysql-connector-java")
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
//그레이들설정이 원래랑 달라서 뭐지하고 보니까 원래는 groovy로 했는데 이거는 kotlin으로 되어잇더라구 그래서 그거 맞춰서 써놓긴했엉
