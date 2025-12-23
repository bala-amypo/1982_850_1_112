@Service
public class CredentialRecordServiceImpl implements CredentialRecordService {

    private final CredentialRecordRepository repository;

    public CredentialRecordServiceImpl(CredentialRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<CredentialRecord> getByHolderId(Long holderId) {
        return repository.findByHolder_Id(holderId);
    }

    @Override
    public CredentialRecord getByCredentialCode(String code) {
        return repository.findByCredentialCode(code)
                .orElseThrow(() -> new RuntimeException("Credential not found"));
    }
}
