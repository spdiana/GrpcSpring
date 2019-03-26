// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: WalletService.proto

package com.grpc;

public final class WalletServiceOuterClass {
  private WalletServiceOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_grpc_AllWallet_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_grpc_AllWallet_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_grpc_WalletRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_grpc_WalletRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_grpc_WalletResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_grpc_WalletResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_grpc_BalanceRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_grpc_BalanceRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_grpc_BalanceResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_grpc_BalanceResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_grpc_BalanceResponse_BalanceByCurrencyEntry_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_grpc_BalanceResponse_BalanceByCurrencyEntry_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\023WalletService.proto\022\010com.grpc\"\013\n\tAllWa" +
      "llet\"U\n\rWalletRequest\022\016\n\006userId\030\001 \001(\003\022\016\n" +
      "\006amount\030\002 \001(\001\022$\n\010currency\030\003 \001(\0162\022.com.gr" +
      "pc.Currency\"\020\n\016WalletResponse\" \n\016Balance" +
      "Request\022\016\n\006userId\030\001 \001(\003\"\230\001\n\017BalanceRespo" +
      "nse\022K\n\021balanceByCurrency\030\001 \003(\01320.com.grp" +
      "c.BalanceResponse.BalanceByCurrencyEntry" +
      "\0328\n\026BalanceByCurrencyEntry\022\013\n\003key\030\001 \001(\t\022" +
      "\r\n\005value\030\002 \001(\001:\0028\001*%\n\010Currency\022\007\n\003EUR\020\000\022" +
      "\007\n\003USD\020\001\022\007\n\003GBP\020\0022\205\002\n\rWalletService\0225\n\003a" +
      "ll\022\023.com.grpc.AllWallet\032\027.com.grpc.Walle" +
      "tRequest0\001\022>\n\007balance\022\030.com.grpc.Balance" +
      "Request\032\031.com.grpc.BalanceResponse\022<\n\007de" +
      "posit\022\027.com.grpc.WalletRequest\032\030.com.grp" +
      "c.WalletResponse\022?\n\nwithdrawal\022\027.com.grp" +
      "c.WalletRequest\032\030.com.grpc.WalletRespons" +
      "eB\002P\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_com_grpc_AllWallet_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_com_grpc_AllWallet_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_grpc_AllWallet_descriptor,
        new java.lang.String[] { });
    internal_static_com_grpc_WalletRequest_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_com_grpc_WalletRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_grpc_WalletRequest_descriptor,
        new java.lang.String[] { "UserId", "Amount", "Currency", });
    internal_static_com_grpc_WalletResponse_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_com_grpc_WalletResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_grpc_WalletResponse_descriptor,
        new java.lang.String[] { });
    internal_static_com_grpc_BalanceRequest_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_com_grpc_BalanceRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_grpc_BalanceRequest_descriptor,
        new java.lang.String[] { "UserId", });
    internal_static_com_grpc_BalanceResponse_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_com_grpc_BalanceResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_grpc_BalanceResponse_descriptor,
        new java.lang.String[] { "BalanceByCurrency", });
    internal_static_com_grpc_BalanceResponse_BalanceByCurrencyEntry_descriptor =
      internal_static_com_grpc_BalanceResponse_descriptor.getNestedTypes().get(0);
    internal_static_com_grpc_BalanceResponse_BalanceByCurrencyEntry_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_grpc_BalanceResponse_BalanceByCurrencyEntry_descriptor,
        new java.lang.String[] { "Key", "Value", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
