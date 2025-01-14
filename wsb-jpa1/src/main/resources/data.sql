-- insert into address (id, address_line1, address_line2, city, postal_code)
--             values (1, 'xx', 'yy', 'city', '62-030');

-- nowe dane do tabeli Address
INSERT INTO ADDRESS (id, city, address_line1, address_line2, postal_code) VALUES
                                                                              (1, 'Gliwice', 'Polna', '9/13', '60-140'),
                                                                              (2, 'Katowice', 'Brzozowa', '5', '04-190');

-- nowe dane do tabeli Doctor
INSERT INTO DOCTOR (id, first_name, last_name, telephone_number, email, doctor_number, specialization, address_id) VALUES
                                                                                                                       (1, 'Jan', 'Kowalski', '123456789', 'janek@example.com', 'DOC123', 'DERMATOLOGIST', 1),
                                                                                                                       (2, 'Karina', 'Mysz', '987654321', 'karina@example.com', 'DOC456', 'SURGEON', 2);

-- nowe dane do tabeli Patient
INSERT INTO PATIENT (id, first_name, last_name, telephone_number, email, patient_number, date_of_birth, address_id, gender) VALUES
                                                                                                                        (1, 'Alicja', 'Nowak', '123123123', 'alicja@example.com', 'PAT789', '1985-05-15', 1, 'FEMALE'),
                                                                                                                        (2, 'Robert', 'Janowski', '321321321', 'bob@example.com', 'PAT101', '1990-08-20', 2, 'MALE'),
                                                                                                                        (3, 'Monika', 'Duch', '147147147', 'mon@example.com', 'PAT456', '2000-05-06', 2, 'OTHER'),
                                                                                                                        (4, 'Malina', 'Krzyk', '147147147', 'mon@example.com', 'PAT456', '2000-12-09', 2, 'FEMALE'),
                                                                                                                        (5, 'Adam', 'Krzyk', '147144347', 'adkrz@example.com', 'PAT457', '2001-02-06', 2, 'MALE'),
                                                                                                                        (6, 'Adam', 'Patyk', '621621621', 'adam@example.com', 'PAT852', '2010-08-10', 2, 'MALE');

-- nowe dane do tabeli Visit
INSERT INTO VISIT (id, description, time, doctor_id, patient_id) VALUES
                                                                     (1, 'Wizyta kontrolna', '2024-12-08 10:00:00', 1, 1),
                                                                     (2, 'Obrazowanie przed zabiegiem', '2024-12-08 14:00:00', 2, 2),
                                                                     (4, 'Badania kontrolne', '2024-12-11 12:00:00', 2, 3),
                                                                     (5, 'Zabieg chirurgiczny', '2024-12-15 08:00:00', 2, 2),
                                                                     (6, 'Kontrola po zabiegu', '2024-12-20 10:30:00', 2, 2);

-- nowe dane do tabeli MedicalTreatment
INSERT INTO MEDICAL_TREATMENT (id, description, type, visit_id) VALUES
                                                                    (1, 'Kontrola funkcji życiowych', 'EKG', 1),
                                                                    (2, 'Kontrola przed zabiegiem', 'RTG', 2);
