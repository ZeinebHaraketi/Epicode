<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;
use Symfony\Component\Validator\Constraints as Assert;

/**
 * Coaching
 *
 * @ORM\Table(name="coaching")
 * @ORM\Entity
 */
class Coaching
{
    /**
     * @var int
     *
     * @ORM\Column(name="Id_S", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idS;

    /**
     * @Assert\Date
     * @var string A "Y-m-d" formatted value
     *
     * 
     * 
     * @ORM\Column(name="Date_S", type="string", length=255, nullable=false)
     */
    private $dateS;

    /**
     * @var float
     *
     * @ORM\Column(name="Prix", type="float", precision=10, scale=0, nullable=false)
     * @Assert\NotBlank
     */
    private $prix;

    /**
     * @var int
     *
     * @Assert\NotBlank
     * @ORM\Column(name="Id_Co", type="integer", nullable=false)
     */
    private $idCo;

    /**
     * 
     *      * @Assert\Length(
     *      min = 2,
     *      max = 50,
     *      minMessage = "Your first name must be at least {{ limit }} characters long",
     *      maxMessage = "Your first name cannot be longer than {{ limit }} characters"
     * )
     *      @Assert\Type(type={"alpha"})
     * @var string
     *
     * @ORM\Column(name="Nom_User", type="string", length=25, nullable=false)
     */
    private $nomUser;

    /**
     * 
     * @var string
     *
     *      @Assert\Length(
     *      min = 3,
     *      max = 50,
     *      minMessage = "Your first name must be at least {{ limit }} characters long",
     *      maxMessage = "Your first name cannot be longer than {{ limit }} characters"
     * )
     * @Assert\Type(type={"alpha"})
     * @ORM\Column(name="Prenom_User", type="string", length=25, nullable=false)
     */
    private $prenomUser;

    public function getIdS(): ?int
    {
        return $this->idS;
    }

    public function getDateS(): ?string
    {
        return $this->dateS;
    }

    public function setDateS(string $dateS): self
    {
        $this->dateS = $dateS;

        return $this;
    }

    public function getPrix(): ?float
    {
        return $this->prix;
    }

    public function setPrix(float $prix): self
    {
        $this->prix = $prix;

        return $this;
    }

    public function getIdCo(): ?int
    {
        return $this->idCo;
    }

    public function setIdCo(int $idCo): self
    {
        $this->idCo = $idCo;

        return $this;
    }

    public function getNomUser(): ?string
    {
        return $this->nomUser;
    }

    public function setNomUser(string $nomUser): self
    {
        $this->nomUser = $nomUser;

        return $this;
    }

    public function getPrenomUser(): ?string
    {
        return $this->prenomUser;
    }

    public function setPrenomUser(string $prenomUser): self
    {
        $this->prenomUser = $prenomUser;

        return $this;
    }


}
