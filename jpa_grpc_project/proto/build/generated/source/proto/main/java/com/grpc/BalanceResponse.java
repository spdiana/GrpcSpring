// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: WalletService.proto

package com.grpc;

/**
 * Protobuf type {@code com.grpc.BalanceResponse}
 */
public  final class BalanceResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.grpc.BalanceResponse)
    BalanceResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use BalanceResponse.newBuilder() to construct.
  private BalanceResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private BalanceResponse() {
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private BalanceResponse(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            if (!((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
              balanceByCurrency_ = com.google.protobuf.MapField.newMapField(
                  BalanceByCurrencyDefaultEntryHolder.defaultEntry);
              mutable_bitField0_ |= 0x00000001;
            }
            com.google.protobuf.MapEntry<java.lang.String, java.lang.Double>
            balanceByCurrency__ = input.readMessage(
                BalanceByCurrencyDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
            balanceByCurrency_.getMutableMap().put(
                balanceByCurrency__.getKey(), balanceByCurrency__.getValue());
            break;
          }
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.grpc.WalletServiceOuterClass.internal_static_com_grpc_BalanceResponse_descriptor;
  }

  @SuppressWarnings({"rawtypes"})
  @java.lang.Override
  protected com.google.protobuf.MapField internalGetMapField(
      int number) {
    switch (number) {
      case 1:
        return internalGetBalanceByCurrency();
      default:
        throw new RuntimeException(
            "Invalid map field number: " + number);
    }
  }
  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.grpc.WalletServiceOuterClass.internal_static_com_grpc_BalanceResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.grpc.BalanceResponse.class, com.grpc.BalanceResponse.Builder.class);
  }

  public static final int BALANCEBYCURRENCY_FIELD_NUMBER = 1;
  private static final class BalanceByCurrencyDefaultEntryHolder {
    static final com.google.protobuf.MapEntry<
        java.lang.String, java.lang.Double> defaultEntry =
            com.google.protobuf.MapEntry
            .<java.lang.String, java.lang.Double>newDefaultInstance(
                com.grpc.WalletServiceOuterClass.internal_static_com_grpc_BalanceResponse_BalanceByCurrencyEntry_descriptor, 
                com.google.protobuf.WireFormat.FieldType.STRING,
                "",
                com.google.protobuf.WireFormat.FieldType.DOUBLE,
                0D);
  }
  private com.google.protobuf.MapField<
      java.lang.String, java.lang.Double> balanceByCurrency_;
  private com.google.protobuf.MapField<java.lang.String, java.lang.Double>
  internalGetBalanceByCurrency() {
    if (balanceByCurrency_ == null) {
      return com.google.protobuf.MapField.emptyMapField(
          BalanceByCurrencyDefaultEntryHolder.defaultEntry);
    }
    return balanceByCurrency_;
  }

  public int getBalanceByCurrencyCount() {
    return internalGetBalanceByCurrency().getMap().size();
  }
  /**
   * <code>map&lt;string, double&gt; balanceByCurrency = 1;</code>
   */

  public boolean containsBalanceByCurrency(
      java.lang.String key) {
    if (key == null) { throw new java.lang.NullPointerException(); }
    return internalGetBalanceByCurrency().getMap().containsKey(key);
  }
  /**
   * Use {@link #getBalanceByCurrencyMap()} instead.
   */
  @java.lang.Deprecated
  public java.util.Map<java.lang.String, java.lang.Double> getBalanceByCurrency() {
    return getBalanceByCurrencyMap();
  }
  /**
   * <code>map&lt;string, double&gt; balanceByCurrency = 1;</code>
   */

  public java.util.Map<java.lang.String, java.lang.Double> getBalanceByCurrencyMap() {
    return internalGetBalanceByCurrency().getMap();
  }
  /**
   * <code>map&lt;string, double&gt; balanceByCurrency = 1;</code>
   */

  public double getBalanceByCurrencyOrDefault(
      java.lang.String key,
      double defaultValue) {
    if (key == null) { throw new java.lang.NullPointerException(); }
    java.util.Map<java.lang.String, java.lang.Double> map =
        internalGetBalanceByCurrency().getMap();
    return map.containsKey(key) ? map.get(key) : defaultValue;
  }
  /**
   * <code>map&lt;string, double&gt; balanceByCurrency = 1;</code>
   */

  public double getBalanceByCurrencyOrThrow(
      java.lang.String key) {
    if (key == null) { throw new java.lang.NullPointerException(); }
    java.util.Map<java.lang.String, java.lang.Double> map =
        internalGetBalanceByCurrency().getMap();
    if (!map.containsKey(key)) {
      throw new java.lang.IllegalArgumentException();
    }
    return map.get(key);
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    com.google.protobuf.GeneratedMessageV3
      .serializeStringMapTo(
        output,
        internalGetBalanceByCurrency(),
        BalanceByCurrencyDefaultEntryHolder.defaultEntry,
        1);
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (java.util.Map.Entry<java.lang.String, java.lang.Double> entry
         : internalGetBalanceByCurrency().getMap().entrySet()) {
      com.google.protobuf.MapEntry<java.lang.String, java.lang.Double>
      balanceByCurrency__ = BalanceByCurrencyDefaultEntryHolder.defaultEntry.newBuilderForType()
          .setKey(entry.getKey())
          .setValue(entry.getValue())
          .build();
      size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(1, balanceByCurrency__);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.grpc.BalanceResponse)) {
      return super.equals(obj);
    }
    com.grpc.BalanceResponse other = (com.grpc.BalanceResponse) obj;

    boolean result = true;
    result = result && internalGetBalanceByCurrency().equals(
        other.internalGetBalanceByCurrency());
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (!internalGetBalanceByCurrency().getMap().isEmpty()) {
      hash = (37 * hash) + BALANCEBYCURRENCY_FIELD_NUMBER;
      hash = (53 * hash) + internalGetBalanceByCurrency().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.grpc.BalanceResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.grpc.BalanceResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.grpc.BalanceResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.grpc.BalanceResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.grpc.BalanceResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.grpc.BalanceResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.grpc.BalanceResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.grpc.BalanceResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.grpc.BalanceResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.grpc.BalanceResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.grpc.BalanceResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.grpc.BalanceResponse parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.grpc.BalanceResponse prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code com.grpc.BalanceResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.grpc.BalanceResponse)
      com.grpc.BalanceResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.grpc.WalletServiceOuterClass.internal_static_com_grpc_BalanceResponse_descriptor;
    }

    @SuppressWarnings({"rawtypes"})
    protected com.google.protobuf.MapField internalGetMapField(
        int number) {
      switch (number) {
        case 1:
          return internalGetBalanceByCurrency();
        default:
          throw new RuntimeException(
              "Invalid map field number: " + number);
      }
    }
    @SuppressWarnings({"rawtypes"})
    protected com.google.protobuf.MapField internalGetMutableMapField(
        int number) {
      switch (number) {
        case 1:
          return internalGetMutableBalanceByCurrency();
        default:
          throw new RuntimeException(
              "Invalid map field number: " + number);
      }
    }
    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.grpc.WalletServiceOuterClass.internal_static_com_grpc_BalanceResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.grpc.BalanceResponse.class, com.grpc.BalanceResponse.Builder.class);
    }

    // Construct using com.grpc.BalanceResponse.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      internalGetMutableBalanceByCurrency().clear();
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.grpc.WalletServiceOuterClass.internal_static_com_grpc_BalanceResponse_descriptor;
    }

    @java.lang.Override
    public com.grpc.BalanceResponse getDefaultInstanceForType() {
      return com.grpc.BalanceResponse.getDefaultInstance();
    }

    @java.lang.Override
    public com.grpc.BalanceResponse build() {
      com.grpc.BalanceResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.grpc.BalanceResponse buildPartial() {
      com.grpc.BalanceResponse result = new com.grpc.BalanceResponse(this);
      int from_bitField0_ = bitField0_;
      result.balanceByCurrency_ = internalGetBalanceByCurrency();
      result.balanceByCurrency_.makeImmutable();
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return (Builder) super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.grpc.BalanceResponse) {
        return mergeFrom((com.grpc.BalanceResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.grpc.BalanceResponse other) {
      if (other == com.grpc.BalanceResponse.getDefaultInstance()) return this;
      internalGetMutableBalanceByCurrency().mergeFrom(
          other.internalGetBalanceByCurrency());
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      com.grpc.BalanceResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.grpc.BalanceResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private com.google.protobuf.MapField<
        java.lang.String, java.lang.Double> balanceByCurrency_;
    private com.google.protobuf.MapField<java.lang.String, java.lang.Double>
    internalGetBalanceByCurrency() {
      if (balanceByCurrency_ == null) {
        return com.google.protobuf.MapField.emptyMapField(
            BalanceByCurrencyDefaultEntryHolder.defaultEntry);
      }
      return balanceByCurrency_;
    }
    private com.google.protobuf.MapField<java.lang.String, java.lang.Double>
    internalGetMutableBalanceByCurrency() {
      onChanged();;
      if (balanceByCurrency_ == null) {
        balanceByCurrency_ = com.google.protobuf.MapField.newMapField(
            BalanceByCurrencyDefaultEntryHolder.defaultEntry);
      }
      if (!balanceByCurrency_.isMutable()) {
        balanceByCurrency_ = balanceByCurrency_.copy();
      }
      return balanceByCurrency_;
    }

    public int getBalanceByCurrencyCount() {
      return internalGetBalanceByCurrency().getMap().size();
    }
    /**
     * <code>map&lt;string, double&gt; balanceByCurrency = 1;</code>
     */

    public boolean containsBalanceByCurrency(
        java.lang.String key) {
      if (key == null) { throw new java.lang.NullPointerException(); }
      return internalGetBalanceByCurrency().getMap().containsKey(key);
    }
    /**
     * Use {@link #getBalanceByCurrencyMap()} instead.
     */
    @java.lang.Deprecated
    public java.util.Map<java.lang.String, java.lang.Double> getBalanceByCurrency() {
      return getBalanceByCurrencyMap();
    }
    /**
     * <code>map&lt;string, double&gt; balanceByCurrency = 1;</code>
     */

    public java.util.Map<java.lang.String, java.lang.Double> getBalanceByCurrencyMap() {
      return internalGetBalanceByCurrency().getMap();
    }
    /**
     * <code>map&lt;string, double&gt; balanceByCurrency = 1;</code>
     */

    public double getBalanceByCurrencyOrDefault(
        java.lang.String key,
        double defaultValue) {
      if (key == null) { throw new java.lang.NullPointerException(); }
      java.util.Map<java.lang.String, java.lang.Double> map =
          internalGetBalanceByCurrency().getMap();
      return map.containsKey(key) ? map.get(key) : defaultValue;
    }
    /**
     * <code>map&lt;string, double&gt; balanceByCurrency = 1;</code>
     */

    public double getBalanceByCurrencyOrThrow(
        java.lang.String key) {
      if (key == null) { throw new java.lang.NullPointerException(); }
      java.util.Map<java.lang.String, java.lang.Double> map =
          internalGetBalanceByCurrency().getMap();
      if (!map.containsKey(key)) {
        throw new java.lang.IllegalArgumentException();
      }
      return map.get(key);
    }

    public Builder clearBalanceByCurrency() {
      internalGetMutableBalanceByCurrency().getMutableMap()
          .clear();
      return this;
    }
    /**
     * <code>map&lt;string, double&gt; balanceByCurrency = 1;</code>
     */

    public Builder removeBalanceByCurrency(
        java.lang.String key) {
      if (key == null) { throw new java.lang.NullPointerException(); }
      internalGetMutableBalanceByCurrency().getMutableMap()
          .remove(key);
      return this;
    }
    /**
     * Use alternate mutation accessors instead.
     */
    @java.lang.Deprecated
    public java.util.Map<java.lang.String, java.lang.Double>
    getMutableBalanceByCurrency() {
      return internalGetMutableBalanceByCurrency().getMutableMap();
    }
    /**
     * <code>map&lt;string, double&gt; balanceByCurrency = 1;</code>
     */
    public Builder putBalanceByCurrency(
        java.lang.String key,
        double value) {
      if (key == null) { throw new java.lang.NullPointerException(); }
      
      internalGetMutableBalanceByCurrency().getMutableMap()
          .put(key, value);
      return this;
    }
    /**
     * <code>map&lt;string, double&gt; balanceByCurrency = 1;</code>
     */

    public Builder putAllBalanceByCurrency(
        java.util.Map<java.lang.String, java.lang.Double> values) {
      internalGetMutableBalanceByCurrency().getMutableMap()
          .putAll(values);
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:com.grpc.BalanceResponse)
  }

  // @@protoc_insertion_point(class_scope:com.grpc.BalanceResponse)
  private static final com.grpc.BalanceResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.grpc.BalanceResponse();
  }

  public static com.grpc.BalanceResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<BalanceResponse>
      PARSER = new com.google.protobuf.AbstractParser<BalanceResponse>() {
    @java.lang.Override
    public BalanceResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new BalanceResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<BalanceResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<BalanceResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.grpc.BalanceResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

