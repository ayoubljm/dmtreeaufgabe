# 🌐 Community Platform

Eine moderne Community-Plattform mit Feedback-System, News, Chat und Admin-Panel, entwickelt mit **Spring Boot** und **Thymeleaf**.

---

## 🚀 Features

### 📰 News
- Admin kann News erstellen
- Unterstützung für Bilder (URL oder statisch)
- Moderne Kartenansicht

### 💬 Feedback / Posts
- !!! WICHTIG !!! Die 2 schon vorhandenen Posts sind nur für die Darstellung da, deswegen haben die keine volle Funktionalität ! Um alle Features benutzen zu wollen bitte eigene Posts erstellen !
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

```text
src/
└── main/
    ├── java/
    │   └── com/dmtree/community/
    │       ├── controller/   # 🎮 Steuerung (MVC Controller)
    │       ├── service/      # ⚙️ Geschäftslogik
    │       ├── repository/   # 💾 Datenbankzugriff
    │       ├── model/        # 📦 Datenmodelle
    │       └── config/       # 🔧 Konfiguration
    │
    └── resources/
        ├── templates/        # 🌐 HTML (Thymeleaf)
        ├── static/
        │   ├── css/          # 🎨 Styles
        │   └── images/       # 🖼️ Bilder
        └── application.properties  # ⚡ Einstellungen
```
---

## ▶️ Installation & Start

### 1. Projekt klonen
- git clone https://github.com/DEIN-USERNAME/community-platform.git

### 2. In Projektordner wechseln
- cd community-platform

### 3. Anwendung starten
- Mit Maven:
./mvnw spring-boot:run
- oder in IntelliJ:
➡ CommunityApplication starten

## 🌍 Anwendung starten (Browser)

Nach dem Start:

👉 Öffne im Browser:
 - http://localhost:8080
 - 
👑 Admin Account
- Email: admin@admin.com
- Passwort: admin123
  
👤 User Account ( Muss registriert werden )
- Email: user@user.com
- Passwort: 123456

🧭 Anleitung zur Nutzung

🔹 1. Login
- Gehe auf Login
- Melde dich als Admin oder User an

🔹 2. News ansehen
- Startseite zeigt News
- Admin kann neue News erstellen

🔹 3. Feedback posten
- Gehe auf Posts
- Klicke auf „Feedback erstellen“
- Schreibe deinen Beitrag

🔹 4. Beiträge bewerten
- 👍 Like
- 👎 Dislike
- Posts werden nach Likes sortiert

🔹 5. Kommentare
- Öffne einen Post
- Schreibe einen Kommentar
- Admin kann Kommentare löschen

🔹 6. Chat nutzen
- 👤 Normaler User:
- Kann Chat sehen
- Kann nicht schreiben, solange nicht freigeschaltet
- 👑 Admin:
- Gehe zu User managen
- Suche User per Email
- Aktiviere Chat-Zugriff

➡ Danach kann der User chatten

🔹 7. Admin Funktionen

Als Admin kannst du:

- User für Chat freischalten
- User entfernen
- News erstellen
- Kommentare löschen

## Systemverhalten

Registrierung notwendig für:
- Posts
- Kommentare

Chat:
- Nur sichtbar für alle
- Nutzbar nur nach Admin-Freigabe

Admin:
- Zugriff auf Admin Panel
- Kann User verwalten 
- Bilder verwenden

## Bilder müssen im Ordner liegen:
- src/main/resources/static/images/
## Verwendung im Formular:
- /images/deinBild.jpg

## Design
- Dark Mode UI
- Modernes Card Layout
- Hover-Effekte & Animationen
- Inspiriert von modernen SaaS Plattformen

## ToDo / Verbesserungen
 - Mobile Responsive Design
 - Chat (WhatsApp Style)
 - Image Upload (statt URL)
 - Live Updates (WebSockets)
 - Pagination für Posts
 
## Autor
- Ayoub Lejmi
- Student an THM Gießen

## Lizenz

- Dieses Projekt dient Lern- und Demonstrationszwecken.
