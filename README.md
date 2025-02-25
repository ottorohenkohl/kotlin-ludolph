# Ludolph

[![pipeline status](http://sources.rohenkohl.dev/entwicklung/kotlin/ludolph/badges/main/pipeline.svg)](http://sources.rohenkohl.dev/entwicklung/kotlin/ludolph/-/commits/main) [![coverage report](http://sources.rohenkohl.dev/entwicklung/kotlin/ludolph/badges/main/coverage.svg)](http://sources.rohenkohl.dev/entwicklung/kotlin/ludolph/-/commits/main) [![Latest Release](http://sources.rohenkohl.dev/entwicklung/kotlin/ludolph/-/badges/release.svg)](http://sources.rohenkohl.dev/entwicklung/kotlin/ludolph/-/releases)

## 1. Projektbeschreibung

Ludolph ist ein Discord-Bot, der automatisch Informationen über Veränderungen in einem laufenden Investmentspiel ausliest und diese in einem Discord-Channel bereitstellt. Dazu gehören:

- Erkennung neuer Käufe und Verkäufe von Aktien
- Überwachung der Platzierungen im Ranking
- Automatische Benachrichtigung der Nutzer

Das Projekt basiert auf **Kotlin**, **Quarkus** und **Gradle** und verwendet **Discord4J** für die Kommunikation mit Discord.

---

## 2. Installation/Einrichtung

### Voraussetzungen

- Eine laufende **Quarkus**-Umgebung
- Ein gültiges Discord-Bot-Token
- Zugangsdaten für die Spiel-API

### Konfiguration

Ludolph verwendet **Eclipse MicroProfile Config** zur Verwaltung der Konfigurationswerte. Diese können entweder als **Umgebungsvariablen** oder innerhalb der **`application.properties`** definiert werden.

| Umgebungsvariable         | [application.properties](src/main/resources/application.properties) | Beschreibung                                   |
|---------------------------|---------------------------------------------------------------------|------------------------------------------------|
| `LUDOLPH_ID_CHANNEL`      | `ludolph.id.channel`                                                | ID des Discord-Channels für Benachrichtigungen |
| `LUDOLPH_ID_GAME`         | `ludolph.id.game`                                                   | ID des Spiels                                  |
| `LUDOLPH_ID_PORTFOLIO`    | `ludolph.id.portfolio`                                              | ID des zu überwachenden Portfolios             |
| `LUDOLPH_ID_USER`         | `ludolph.id.user`                                                   | Benutzer-ID für den API-Zugriff                |
| `LUDOLPH_USER_EMAIL`      | `ludolph.user.email`                                                | Login-E-Mail für das Spiel                     |
| `LUDOLPH_USER_PASSWORD`   | `ludolph.user.password`                                             | Passwort für den API-Zugang                    |
| `QUARKUS_DISCORD4J_TOKEN` | `quarkus.discord4j.token`                                           | Token für den Discord-Bot                      |

---

## 3. Nutzung/Beispiele

```sh
./gradlew quarkusDev
```

