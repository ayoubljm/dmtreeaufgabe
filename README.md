# 🌐 Community Platform

Eine moderne Community-Plattform mit Feedback-System, News, Chat und Admin-Panel, entwickelt mit **Spring Boot** und **Thymeleaf**.

---

## 🚀 Features

### 📰 News
- Admin kann News erstellen
- Unterstützung für Bilder (URL oder statisch)
- Moderne Kartenansicht

### 💬 Feedback / Posts
- User können Feedback posten
- Like / Dislike System
- Sortierung nach Likes

### 🧵 Kommentare
- Kommentare pro Post
- Zeitstempel
- Admin kann Kommentare löschen

### 💬 Chat System
- Community Chat
- Zugriff nur für eingeladene User
- Admin kann User freischalten

### 🔐 Authentifizierung
- Login / Registrierung
- Rollen:
  - USER
  - ADMIN

### ⚙️ Admin Panel
- User suchen
- Chat-Zugriff vergeben / entfernen
- News erstellen

---

## 🛠️ Technologien

- Java
- Spring Boot
- Spring Security
- Thymeleaf
- JPA / Hibernate
- HTML / CSS (Custom Design)

---

## 📁 Projektstruktur

src/main/java/com/dmtree/community
│
├── controller
├── service
├── repository
├── model
├── config

src/main/resources
│
├── templates → HTML Seiten
├── static/css → Styles
├── static/images → Bilder
└── application.properties
---

## ▶️ Installation & Start

### 1. Projekt klonen
-git clone https://github.com/DEIN-USERNAME/community-platform.git

### 2. In Projektordner wechseln
cd community-platform

### 3. Anwendung starten
-Mit Maven:
./mvnw spring-boot:run
-oder in IntelliJ:
➡ CommunityApplication starten

## Systemverhalten

Registrierung notwendig für:
-Posts
-Kommentare

Chat:
-Nur sichtbar für alle
-Nutzbar nur nach Admin-Freigabe

Admin:
-Zugriff auf Admin Panel
-Kann User verwalten 
-Bilder verwenden

## Bilder müssen im Ordner liegen:
-src/main/resources/static/images/
Verwendung im Formular:
-/images/deinBild.jpg

## Design
-Dark Mode UI
-Modernes Card Layout
-Hover-Effekte & Animationen
-Inspiriert von modernen SaaS Plattformen

## ToDo / Verbesserungen
 -Mobile Responsive Design
 -Chat (WhatsApp Style)
 -Image Upload (statt URL)
 -Live Updates (WebSockets)
 -Pagination für Posts
 
## Autor
-Ayoub Lejmi
-Student an THM Gießen

## Lizenz

Dieses Projekt dient Lern- und Demonstrationszwecken.
