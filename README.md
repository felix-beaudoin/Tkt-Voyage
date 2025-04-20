📦 Plateforme de Réservation Multimodale
✈️🚆🛳️ Description

Ce projet est une plateforme de gestion de réservations de voyages permettant de réserver des billets pour l’avion, le train et le bateau. Elle vise à offrir une interface unifiée pour les différents types de transports, tout en gardant une architecture extensible et maintenable grâce à l’application de patrons de conception (design patterns).
🎯 Objectifs

    Permettre à un utilisateur de rechercher, réserver et annuler un voyage en avion, train ou bateau.

    Offrir une architecture orientée objet qui facilite l’ajout de nouveaux types de transport à l’avenir.

    Mettre en œuvre des design patterns pour améliorer la flexibilité et la réutilisabilité du code.

🧱 Architecture

Le système repose sur plusieurs patrons de conception :

    Factory Method : pour instancier dynamiquement les bons objets de réservation selon le type de transport.

    Observer (si applicable) : pour notifier les utilisateurs de changements (ex : annulations, retards).

    Decorator (optionnel) : pour ajouter dynamiquement des options à une réservation (repas, assurance, etc.).

🛠️ Technologies

    Langage : Java

    Paradigme : Programmation orientée objet (OOP)

✅ Fonctionnalités principales

    Création et gestion de comptes utilisateurs

    Recherche de voyages disponibles

    Réservation, modification et annulation de billets

    Affichage des détails d’un trajet

    Historique des réservations ???

🚀 Extension possible

    Ajout de nouveaux modes de transport (bus, covoiturage, etc.)

    Paiement en ligne

    Suggestions de voyages multimodaux

    Intégration avec une API de géolocalisation

📁 Structure du projet (exemple)

👨‍💻 Auteurs

    Équipe :    Karl Desjardins(20196433)
                Felix Beaudoin ()
                Francis


    Cours : 3911 - Analyse et conception des logiciels

    Enseignant·e : Eugene Syriani