<?php

declare(strict_types=1);

namespace DoctrineMigrations;

use Doctrine\DBAL\Schema\Schema;
use Doctrine\Migrations\AbstractMigration;

/**
 * Auto-generated Migration: Please modify to your needs!
 */
final class Version20220414183312 extends AbstractMigration
{
    public function getDescription(): string
    {
        return '';
    }

    public function up(Schema $schema): void
    {
        // this up() migration is auto-generated, please modify it to your needs
        $this->addSql('ALTER TABLE activite CHANGE id_enfant id_enfant INT DEFAULT NULL');
        $this->addSql('ALTER TABLE commentaire CHANGE Id_b Id_b INT DEFAULT NULL');
        $this->addSql('ALTER TABLE cours ADD image_cours VARCHAR(255) NOT NULL');
        $this->addSql('ALTER TABLE programme CHANGE Id_c Id_c INT DEFAULT NULL');
        $this->addSql('ALTER TABLE user CHANGE id id INT AUTO_INCREMENT NOT NULL');
    }

    public function down(Schema $schema): void
    {
        // this down() migration is auto-generated, please modify it to your needs
        $this->addSql('ALTER TABLE activite CHANGE id_enfant id_enfant INT NOT NULL');
        $this->addSql('ALTER TABLE commentaire CHANGE Id_b Id_b INT NOT NULL');
        $this->addSql('ALTER TABLE cours DROP image_cours');
        $this->addSql('ALTER TABLE programme CHANGE Id_c Id_c INT NOT NULL');
        $this->addSql('ALTER TABLE user CHANGE id id INT NOT NULL');
    }
}
