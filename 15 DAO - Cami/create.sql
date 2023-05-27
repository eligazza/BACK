GO
IF NOT EXISTS CREATE TABLE DOMICILIOS (ID INT AUTO_INCREMENT PRIMARY KEY,
                           CALLE VARCHAR(50),
                           NUMERO INT,
                           LOCALIDAD VARCHAR(50),
                           PROVINCIA VARCHAR(50));

GO

IF NOT EXISTS CREATE TABLE PACIENTES (id INT AUTO_INCREMENT PRIMARY KEY,
                                      nombre VARCHAR(25),
                                      apellido VARCHAR(25),
                                      dni VARCHAR(20),
                                      fechaIngreso DATE,
                                      id_domicilio INT);


