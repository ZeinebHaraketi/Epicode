<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;
use Symfony\Component\Validator\Constraints as Assert;

/**
 * Cours
 *
 * @ORM\Table(name="cours")
 * @ORM\Entity
 */
class Cours
{
    protected $captchaCode;
    
    public function getCaptchaCode()
    {
      return $this->captchaCode;
    }

    public function setCaptchaCode($captchaCode)
    {
      $this->captchaCode = $captchaCode;
    }
    /**
     * @var int
     *
     * @ORM\Column(name="Id_C", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idC;

    /**
     * @var string
     * @Assert\NotBlank
     *
     * @ORM\Column(name="Nom_C", type="string", length=255, nullable=false)
     * @Assert\Length(
     *      min = 2,
     *      max = 50,
     *      minMessage = "Your first name must be at least {{ limit }} characters long",
     *      maxMessage = "Your first name cannot be longer than {{ limit }} characters"
     * 
     * )
     *     @Assert\Type(type={"alpha"})
     */
    private $nomC;

    /**
     * @Assert\Date
     * @var string A "Y-m-d" formatted value

     *
     * @ORM\Column(name="Date_C", type="string", length=255, nullable=false)
     * 
     */
    private $dateC;

    /**
     * @var int
     * @ORM\Column(name="Id_Co", type="integer", nullable=false)
     */
    private $idCo;

    /**
     * @ORM\Column(type="string", length=255)

     */
    private $ImageCours;

    public function getIdC(): ?int
    {
        return $this->idC;
    }

    public function getNomC(): ?string
    {
        return $this->nomC;
    }

    public function setNomC(string $nomC): self
    {
        $this->nomC = $nomC;

        return $this;
    }

    public function getDateC(): ?string
    {
        return $this->dateC;
    }

    public function setDateC(string $dateC): self
    {
        $this->dateC = $dateC;

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

    public function getImageCours(): ?string
    {
        return $this->ImageCours;
    }

    public function setImageCours(string $ImageCours): self
    {
        $this->ImageCours = $ImageCours;

        return $this;
    }


}
