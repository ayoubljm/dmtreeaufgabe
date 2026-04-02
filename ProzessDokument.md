# 🧠 Prozessdokumentation – Entwicklung der Community Plattform

## 1. Projektidee

Zu Beginn des Projekts stand die Idee, eine moderne Community-Plattform zu entwickeln, auf der Nutzer Feedback und Vorschläge teilen können. Ziel war es, eine Anwendung zu bauen, die sowohl funktional als auch optisch an moderne Webanwendungen angelehnt ist.

Die Plattform sollte folgende Kernfunktionen enthalten:

* Veröffentlichung von News
* Erstellung von Feedback-Posts
* Kommentarfunktion
* Like/Dislike-System
* Community-Chat
* Admin-Bereich zur Benutzerverwaltung

---

## 2. Planung und Architektur

Die Anwendung wurde als klassische Webanwendung mit dem **Spring Boot Framework** umgesetzt.
Die Architektur basiert auf dem MVC-Prinzip:

* **Model** → Datenstrukturen (User, Post, Comment, News)
* **View** → HTML-Seiten mit Thymeleaf
* **Controller** → Steuerung der Logik und Routing

Zusätzlich wurde eine klare Trennung in folgende Schichten vorgenommen:

* Controller
* Service
* Repository (Datenbankzugriff)

---

## 3. Verwendete Technologien und Hilfsmittel

### Backend

* Java
* Spring Boot
* Spring Security (Authentifizierung & Rollen)
* JPA / Hibernate (Datenbank)

### Frontend

* HTML
* CSS (Custom Design)
* Thymeleaf (Server-Side Rendering)

### Tools

* IntelliJ IDEA
* Maven
* Git / GitHub

### Unterstützung / Hilfsmittel

* Dokumentation von Spring Boot
* Online-Recherche
* KI-Unterstützung (ChatGPT) für:

  * Debugging
  * Architekturentscheidungen
  * UI/UX Verbesserungen
  * CSS Optimierung

---

## 4. Implementierung (Schritt für Schritt)

### 4.1 Benutzerverwaltung

Zunächst wurde ein User-System aufgebaut:

* Registrierung und Login
* Passwortverschlüsselung mit BCrypt
* Rollen (USER / ADMIN)

### 4.2 Security (Spring Security)

* Zugriffsbeschränkungen für bestimmte Bereiche
* Admin-Only Funktionen
* Schutz von Endpunkten

---

### 4.3 News-System

* Admin kann News erstellen
* Anzeige von News auf der Startseite
* Integration von Bildern (über URL oder statische Dateien)

---

### 4.4 Feedback / Post-System

* Nutzer können Beiträge erstellen
* Anzeige aller Beiträge
* Like/Dislike Funktion
* Sortierung nach Beliebtheit

---

### 4.5 Kommentarsystem

* Kommentare pro Beitrag
* Zeitstempel
* Admin kann Kommentare löschen

---

### 4.6 Chat-System

* Community Chat implementiert
* Zugriff nur für freigeschaltete Nutzer
* Admin kann Nutzer für den Chat aktivieren oder entfernen

---

### 4.7 Admin Panel

* Übersicht über alle Nutzer
* Suche nach Nutzern per Email
* Chat-Zugriff verwalten
* News erstellen

---

### 4.8 Frontend & Design

Das Design wurde schrittweise verbessert:

* Dark Mode UI
* Kartenbasierte Darstellung (Cards)
* Hover-Effekte
* Moderne Navigation (Navbar)
* Responsive Ansätze

---

## 5. Schwierigkeiten und Herausforderungen

### 5.1 Spring Security Probleme

Ein großes Problem war die Konfiguration der Security:

* Bestimmte Seiten waren nicht erreichbar
* Statische Inhalte (z. B. Bilder) wurden blockiert
  → Lösung: `permitAll()` für `/images/**`

---

### 5.2 Verständnis von MVC

Am Anfang war es schwierig, die Trennung zwischen:

* Controller
* Service
* Repository
  richtig zu verstehen und sauber umzusetzen.

---

### 5.3 Dynamische Inhalte vs. statische Tests

* Beispiel-Posts funktionierten nicht (kein Backend)
* Unterschied zwischen echten Daten und HTML-Dummy-Inhalten musste verstanden werden

---

### 5.4 Frontend Layout (CSS)

* Probleme mit Flexbox (z. B. Bild/Text Layout)
* Responsives Verhalten
* Einheitliches Design über mehrere Seiten hinweg

---

### 5.5 Debugging

* Fehlerseiten ohne klare Ursache
* Probleme bei Weiterleitungen
* Mapping-Fehler im Controller

---

## 6. Lösungen und Learnings

Durch das Projekt wurden folgende Fähigkeiten verbessert:

* Verständnis von **Spring Boot Architektur**
* Umgang mit **Spring Security**
* Arbeiten mit **Datenbanken (JPA)**
* Strukturierung von größeren Projekten
* UI/UX Design im Frontend
* Debugging und Fehleranalyse

Ein wichtiger Lernpunkt war:

> „Frontend funktioniert nur korrekt, wenn Backend und Routing sauber aufgebaut sind.“

---

## 7. Ergebnis

Am Ende entstand eine vollständige Webanwendung mit:

* funktionierendem Login-System
* Rollenverwaltung
* Feedback-Plattform
* Kommentarsystem
* Chat mit Zugriffskontrolle
* Admin-Panel
* modernem UI

---

## 8. Ausblick / Verbesserungsmöglichkeiten

* Live-Chat mit WebSockets
* Bild-Upload statt URL
* Pagination für große Datenmengen
* Mobile Optimierung
* Echtzeit-Updates
* Benutzerprofile

---

## 9. Fazit

Das Projekt hat gezeigt, wie komplex die Entwicklung einer vollständigen Webanwendung ist.
Besonders wertvoll war die Kombination aus Backend-Logik, Security und Frontend-Design.

Die größten Fortschritte wurden im Verständnis von:

* Systemarchitektur
* Security-Konfiguration
* Datenfluss zwischen Frontend und Backend
  gemacht.

---


