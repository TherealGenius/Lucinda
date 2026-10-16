# Security Policy & 24/7 Autonomous Zero-Trust Governance (`Lucinda`)

## 1. Säkerhetsfilosofi: Zero Trust ("Never Trust, Always Verify")
Detta arkiv (`curtfurumark/Lucinda`) tillämpar en kompromisslös defensiv säkerhetsstandard för Kotlin Multiplatform (Android, iOS, Desktop JVM). Ingen kod, inget tredjepartsberoende och ingen konfiguration betraktas som säker förrän den har genomgått formell verifiering.

All utveckling och automatiserad övervakning på grenarna `master` och `adam` styrs av två specialistprotokoll i repot:
- **`agent1.md`**: Ansvarar för `/composeApp` (`commonMain`, `androidMain`, `jvmMain`), Gradle-härdning, minnessäkerhet och Google Play Store-efterlevnad.
- **`agent2.md`**: Ansvarar för `/composeApp/src/iosMain` och `/iosApp` (Swift/SwiftUI), Kotlin/Native-bryggan (`cinterop`), ARC-minneshantering och Apple App Store-efterlevnad.

---

## 2. Versioner som stöds (Supported Versions)

Endast aktivt härdade grenar erhåller automatiserade 24/7-säkerhetsuppdateringar och kontinuerlig *Threat Hunting*.

| Gren / Version | Status | Fokus |
| :--- | :---: | :--- |
| `master` | ✅ Stöds (24/7) | Produktionsredo baslinje – låst med Execution Gate |
| `adam` | ✅ Stöds (24/7) | Aktiv utvecklings-/härdningsgren – kontinuerlig verifiering |
| Äldre commits / otaggade grenar | ❌ Stöds ej | Omfattas ej av SLA eller säkerhetsgarantier |

---

## 3. Den Kontinuerliga 24/7 SOC-Loopen

Säkerhetsarbetet i `Lucinda` upphör aldrig utan körs i en sluten cykel både vid varje kodändring (Pull Request / Push) och via schemalagd nattlig granskning:

```text
[Granska] ──> [Analysera] ──> [Åtgärda] ──> [Verifiera]
   ▲                                             │
   └─────────────────────────────────────────────┘
