<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Consultation
 *
 * @ORM\Table(name="consultation")
 * @ORM\Entity
 */
class Consultation
{
    /**
     * @var int
     *
     * @ORM\Column(name="Id_c", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idC;

    /**
     * @var string
     *
     * @ORM\Column(name="Nom", type="string", length=255, nullable=false)
     */
    private $nom;

    /**
     * @var int
     *
     * @ORM\Column(name="Age", type="integer", nullable=false)
     */
    private $age;

    /**
     * @var string
     *
     * @ORM\Column(name="Sexe", type="string", length=255, nullable=false)
     */
    private $sexe;

    /**
     * @var string
     *
     * @ORM\Column(name="Date_rdv", type="string", length=255, nullable=false)
     */
    private $dateRdv;

    /**
     * @var string
     *
     * @ORM\Column(name="Etat_physique", type="string", length=255, nullable=false)
     */
    private $etatPhysique;

    /**
     * @var string
     *
     * @ORM\Column(name="categorie_c", type="string", length=255, nullable=false)
     */
    private $categorieC;

    /**
     * @var string
     *
     * @ORM\Column(name="Prenom", type="string", length=255, nullable=false)
     */
    private $prenom;

    /**
     * @var string
     *
     * @ORM\Column(name="Email", type="string", length=255, nullable=false)
     */
    private $email;

    public function getIdC(): ?int
    {
        return $this->idC;
    }

    public function getNom(): ?string
    {
        return $this->nom;
    }

    public function setNom(string $nom): self
    {
        $this->nom = $nom;

        return $this;
    }

    public function getAge(): ?int
    {
        return $this->age;
    }

    public function setAge(int $age): self
    {
        $this->age = $age;

        return $this;
    }

    public function getSexe(): ?string
    {
        return $this->sexe;
    }

    public function setSexe(string $sexe): self
    {
        $this->sexe = $sexe;

        return $this;
    }

    public function getDateRdv(): ?string
    {
        return $this->dateRdv;
    }

    public function setDateRdv(string $dateRdv): self
    {
        $this->dateRdv = $dateRdv;

        return $this;
    }

    public function getEtatPhysique(): ?string
    {
        return $this->etatPhysique;
    }

    public function setEtatPhysique(string $etatPhysique): self
    {
        $this->etatPhysique = $etatPhysique;

        return $this;
    }

    public function getCategorieC(): ?string
    {
        return $this->categorieC;
    }

    public function setCategorieC(string $categorieC): self
    {
        $this->categorieC = $categorieC;

        return $this;
    }

    public function getPrenom(): ?string
    {
        return $this->prenom;
    }

    public function setPrenom(string $prenom): self
    {
        $this->prenom = $prenom;

        return $this;
    }

    public function getEmail(): ?string
    {
        return $this->email;
    }

    public function setEmail(string $email): self
    {
        $this->email = $email;

        return $this;
    }


}
