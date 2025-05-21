Montreal Shipping System

This Java program simulates a shipping system for all Montreal universities. It is designed to manage and track parcel stamps and prepaid labels efficiently across multiple registries.

Project Description

The system revolves around three main classes: Stamps, Label, and Registry, along with a user-friendly driver class, MissDemo, that facilitates interaction via a command-line interface.

Features:
Stamps Management (Stamps class).
Tracks five categories of stamps.
Allows adding stamps and calculates their total monetary value.
Provides equality checks and formatted output of stamp details.
Label Management (Label class):
Stores label type, ID, unit, and expiry date.
Provides methods to display formatted expiry dates and compare labels.
Registry System (Registry class):
Manages shipping records using both Stamps and Label classes.

Supports:
Comparing registries based on total stamp value.
Comparing the number of stamps in each category.
Adding and removing labels.
Updating expiry dates.
Inventory summaries and formatted registry breakdowns.
User Interaction (MissDemo class):
Console-based UI offering 10 options:
View all registries.
View a specific registry.
Find registries with the same stamp dollar value.
Find registries with the same number of stamp types.
Find registries with the same stamp value and label count.
Add a prepaid label to a registry.
Remove a prepaid label from a registry.
Update expiry date of a label.
Add stamps to a registry.
Quit the program.
Handles user input and guides through various registry operations.


Technologies Used:
Java (Standard Edition)
Command Line Interface (CLI)
Object-Oriented Programming principles
