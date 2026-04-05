import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LocalizationService {

    private static final LocalizationService INSTANCE = new LocalizationService();

    private final Map<String, Map<String, String>> cache = new HashMap<>();
    private String currentLanguage = "en";

    private LocalizationService() {}

    public static LocalizationService getInstance() {
        return INSTANCE;
    }

    public void setCurrentLanguage(String language) {
        this.currentLanguage = language;
        if (!cache.containsKey(language)) {
            loadStrings(language);
        }
    }

    public void loadStrings(String language) {
        Map<String, String> strings = new HashMap<>();
        String sql = "SELECT `key`, value FROM localization_strings WHERE language = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, language);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    strings.put(rs.getString("key"), rs.getString("value"));
                }
            }
        } catch (SQLException e) {
            System.err.println("Failed to load localization strings: " + e.getMessage());
        }
        cache.put(language, strings);
    }

    public String getString(String key) {
        Map<String, String> strings = cache.getOrDefault(currentLanguage, Collections.emptyMap());
        return strings.getOrDefault(key, key);
    }

    public Set<String> getAllKeys() {
        return cache.getOrDefault(currentLanguage, Collections.emptyMap()).keySet();
    }
}
