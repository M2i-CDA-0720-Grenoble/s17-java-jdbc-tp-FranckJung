# Travaux pratiques - Java / JDBC

Tu aimes les emojis? Moi, j'en mets à toutes les sauces! 🥳😍😏

Problème: notre clavier n'est pas vraiment conçu pour pouvoir les retrouver facilement. 😅 Pour pouvoir gagner du temps quand j'écris mes notes de blog, ou mes posts sur Facebook, à partir de mon ordinateur, ce serait top si j'avais une application qui me permette de les retrouver rapidement! 🤩 Ou encore mieux, à qui je pourrais donner un texte contenant des codes correspondant à chaque emoji, et qui les placerait automatiquement au bon endroit! 🚀

Ressource: https://emojipedia.org/

## Installation

- Cloner ce dépôt.
- Utiliser Maven pour ajouter le pilote JDBC correspondant à votre moteur de base de données.
- Installer les dépendances avec Maven.
- Créer une nouvelle base de données et importer le fichier **database.sql**.

## 1. Créer une connexion à la base de données

Etablir une connexion à la base de données, et la tester avec une requête simple, pour afficher tous les emojis dans la console.

## 2. Trouver un emoji par son code

Demander une saisie à l'utilisateur, puis trouver l'emoji correspondant à celle-ci, s'il existe. Sinon, afficher un message disant qu'aucun emoji ne correspond à cette saisie.

### BONUS (facultatif)

A la place, renvoyer tous les emojis dont le code correspond partiellement à la saisie de l'utilisateur (par exempple, `heart` devrait renvoyer 😍 et 😘).

## 3. Trouver un emoji par sa catégorie

Si la saisie de l'utilisateur correspond à un nom de catégorie (tag), afficher la liste de tous les emojis correspondant (en plus des résultats éventuels des étapes précédentes).

## 4. Sélectionner un emoji

Parmi tous les résultats retournés par l'application, le cas échéant, l'utilisateur doit pouvoir en sélectionner un. Quand l'utilisateur choisit un emoji, celui-ci doit automatiquement être copié dans son presse-papier (l'utilisateur n'a plus qu'à sélectionner "Coller" ou appuyer sur CTRL+V pour coller l'emoji à l'endroit qui lui convient).

<details>
  <summary>Indice</summary>

  [Comment copier dans le presse-papier en Java](https://stackoverflow.com/questions/6710350/copying-text-to-the-clipboard-using-java)
</details>

## 5. Ajouter un nouvel emoji

Si l'utilisateur ne trouver pas l'emoji désiré dans la liste présentée par l'application, il doit avoir une option lui permettant de soumettre un nouvel emoji. Il doit alors avoir accès à un menu lui permettant d'ajouter des tags à cet emoji.

## BONUS - convertir un fichier texte

Crée un deuxième point d'entrée dans l'application qui attend comme argument un nom de fichier. Si le fichier concerné est un fichier texte, l'application doit trouver tous les codes d'emoji signalés par une paire de `:` et les remplacer par l'emoji correspondant.

Par exemple:

> Salut! :grin: Comment ça va? :yum:

Devrait être remplacé par:

> Salut! 😀 Comment ça va? 😋
