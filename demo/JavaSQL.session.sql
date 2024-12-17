CREATE TABLE IF NOT EXISTS materials (
    id INT AUTO_INCREMENT PRIMARY KEY,
    material_type VARCHAR(255) NOT NULL,
    weight DOUBLE NOT NULL,
    impact_factor DOUBLE NOT NULL
);

