@Entity
public class CredentialRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String credentialCode;

    @ManyToOne
    @JoinColumn(name = "holder_id")
    private CredentialHolderProfile holder;

    private LocalDate expiryDate;
}
